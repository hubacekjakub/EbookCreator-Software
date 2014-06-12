/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertor;

import java.io.File;
import java.util.Vector;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Hubacek
 */
class XMLBuilder {

    private Metadata metadata;
    private Vector<File> files;

    public XMLBuilder(Metadata metadata, Vector<File> files) {
        this.metadata = metadata;
        this.files = files;

    }

    public void getOPF(File outputFile) {
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();

            //namespaces
            Attr opfNamespace = doc.createAttribute("xmlns:opf");
            opfNamespace.setValue("http://www.idpf.org/2007/opf");
            Attr dcNamespace = doc.createAttribute("xmlns:dc");
            dcNamespace.setValue("http://purl.org/dc/elements/1.1/");

            Element rootElement = doc.createElement("package");
            rootElement.setAttribute("xmlns", "http://www.idpf.org/2007/opf");
            rootElement.setAttribute("unique-identifier", "BookID");
            doc.appendChild(rootElement);

            // metadata element and namespaces
            appendMetadata(metadata, doc, rootElement);
            appendManifest(files, doc, rootElement); // write the content into xml file
            appendSpine(doc, rootElement);
            appendGuide(doc, rootElement);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
		//StreamResult result = new StreamResult(new File("C:\\Dokumenty\\file.xml"));

            // Output to console for testing
            StreamResult result = new StreamResult(outputFile);

            transformer.transform(source, result);

            //System.out.println("File saved!");
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

    private void appendMetadata(Metadata metadata, Document doc, Element rootElement) {
        String bookSubject = "E-book";
        String bookTitle = "";
        String bookDate = "";
        String bookCreator = "";
        String bookLang = "";
        String bookIdentifier = "";
        String bookPublisher = "";
        String bookDesc = "";
        String bookCoverPath = "";
        String bookContributor = "";

        Vector<String> required = metadata.getRequired();
        Vector<String> optional = metadata.getOptional();
        if (required.size() > 0) {
            bookTitle = required.get(0);
            bookCreator = required.get(1);
            bookLang = required.get(2);
        }
        if (optional.size() > 0) {
            bookDate = optional.get(3);
            bookIdentifier = optional.get(2);
            bookDesc = optional.get(4);
            bookContributor = optional.get(1);
            bookPublisher = optional.get(0);
            bookCoverPath = optional.get(5);
        }

        Element metaElement = doc.createElement("metadata");
        metaElement.setAttribute("xmlns:opf", "http://www.idpf.org/2007/opf");
        metaElement.setAttribute("xmlns:dc", "http://purl.org/dc/elements/1.1/");
        rootElement.appendChild(metaElement);

        // elements
        Element title = doc.createElement("dc:title");
        Element language = doc.createElement("dc:language");
        Element identifier = doc.createElement("dc:identifier");
        identifier.setAttribute("id", "BookID");
        identifier.setAttribute("opf:scheme", "ISBN");

        Element date = doc.createElement("dc:date");
        Element creator = doc.createElement("dc:creator");
        creator.setAttribute("opf:role", "aut");

        Element subject = doc.createElement("dc:subject");
        Element description = doc.createElement("dc:description");
        Element contributor = doc.createElement("dc:contributor");
        Element publisher = doc.createElement("dc:publisher");

        title.appendChild(doc.createTextNode(bookTitle));
        language.appendChild(doc.createTextNode(bookLang));
        identifier.appendChild(doc.createTextNode(bookIdentifier));
        date.appendChild(doc.createTextNode(bookDate));
        creator.appendChild(doc.createTextNode(bookCreator));
        subject.appendChild(doc.createTextNode(bookSubject));
        description.appendChild(doc.createTextNode(bookDesc));
        contributor.appendChild(doc.createTextNode(bookContributor));
        publisher.appendChild(doc.createTextNode(bookPublisher));

        //append to metadata
        metaElement.appendChild(title);
        metaElement.appendChild(language);
        metaElement.appendChild(identifier);
        metaElement.appendChild(date);
        metaElement.appendChild(creator);
        metaElement.appendChild(subject);
        metaElement.appendChild(description);
        metaElement.appendChild(contributor);
        metaElement.appendChild(publisher);

        if (bookCoverPath != null) {
            Element cover = doc.createElement("x-metadata");
            Element EmbeddedCover = doc.createElement("EmbeddedCover");
            File coverFile = new File(bookCoverPath);
            String bookName = coverFile.getName();
            String bookExtension = bookName.substring(bookName.lastIndexOf(".") + 1);
            EmbeddedCover.appendChild(doc.createTextNode("cover." + bookExtension));
            cover.appendChild(EmbeddedCover);
            metaElement.appendChild(cover);
        }

    }

    private void appendManifest(Vector<File> files, Document doc, Element rootElement) {
        Element manifest = doc.createElement("manifest");
        rootElement.appendChild(manifest);

        for (File file : files) {
            String absolutePath = file.getAbsolutePath();
            Element item = doc.createElement("item");
            if (absolutePath.endsWith(".ncx")) {

                item.setAttribute("href", file.getName());
                item.setAttribute("id", "ncx");
                item.setAttribute("media-type", "application/x-dtbncx+xml");

            } else if (absolutePath.endsWith(".html")) {
                item.setAttribute("href", file.getName());
                if (file.getName().startsWith("toc")) {
                    item.setAttribute("id", "toc");
                } else {

                    int pos = file.getName().lastIndexOf(".");
                    String fname = file.getName().substring(0, pos);
                    item.setAttribute("id", fname);
                }
                item.setAttribute("media-type", "application/xhtml+xml");
            } else if (absolutePath.endsWith(".gif") || absolutePath.endsWith(".jpg") || absolutePath.endsWith(".jpeg")) {
                String nameOfFile = file.getName();
                item.setAttribute("href", "cover." + nameOfFile.substring(nameOfFile.lastIndexOf(".") + 1));
                item.setAttribute("id", "cover");
                item.setAttribute("media-type", "image/gif");
            }
            manifest.appendChild(item);

        }
    }

    private void appendSpine(Document doc, Element rootElement) {
        Element spine = doc.createElement("spine");
        rootElement.appendChild(spine);
        spine.setAttribute("toc", "ncx");

        Element intro = doc.createElement("itemref");
        intro.setAttribute("idref", "uvod");
        spine.appendChild(intro);
        
        Element toc = doc.createElement("itemref");
        toc.setAttribute("idref", "toc");
        spine.appendChild(toc);

        Element content = doc.createElement("itemref");
        content.setAttribute("idref", "content");
        spine.appendChild(content);



    }

    private void appendGuide(Document doc, Element rootElement) {
        Element guide = doc.createElement("guide");
        rootElement.appendChild(guide);

        Element referenceToc = doc.createElement("reference");
        referenceToc.setAttribute("type", "toc");
        referenceToc.setAttribute("title", "Table of Contents");
        referenceToc.setAttribute("href", "toc.html");
        guide.appendChild(referenceToc);

        Element referenceContent = doc.createElement("reference");
        referenceContent.setAttribute("type", "text");
        referenceContent.setAttribute("title", "Wellcome");
        referenceContent.setAttribute("href", "uvod.html");
        guide.appendChild(referenceContent);
        rootElement.appendChild(guide);

    }

    public void getNCX(File outputFile, Vector<String> toc) {

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();

            //namespaces
            Element rootElement = doc.createElement("ncx");
            rootElement.setAttribute("xmlns", "http://www.daisy.org/z3986/2005/ncx/");
            rootElement.setAttribute("version", "2005-1");
            rootElement.setAttribute("xml:lang", "en");

            doc.appendChild(rootElement);

            // metadata, head and navigation map
            //appendNCXMetadata(doc,rootElement);
            appendTitleAndCreator(doc, rootElement);
            appendNavPoints(doc, rootElement, toc);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "-//NISO//DTD ncx 2005-1//EN");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "http://www.daisy.org/z3986/2005/ncx-2005-1.dtd");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(outputFile);
            transformer.transform(source, result);

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }

    }

    private void appendNCXMetadata(Document doc, Element rootElement) {
        Element head = doc.createElement("head");
        Element bookID = doc.createElement("meta");
        bookID.setAttribute("dtb:uid", "BookID");

        Element depth = doc.createElement("meta");
        depth.setAttribute("dtb:depth", "2");

        Element totalPageCount = doc.createElement("meta");
        totalPageCount.setAttribute("dtb:totalPageCount", "0");

        Element maxPageNumber = doc.createElement("meta");
        maxPageNumber.setAttribute("dtb:maxPageNumber", "0");

        head.appendChild(depth);
        head.appendChild(bookID);
        head.appendChild(totalPageCount);
        head.appendChild(maxPageNumber);
        rootElement.appendChild(head);
    }

    private void appendTitleAndCreator(Document doc, Element rootElement) {
        Element title = doc.createElement("docTitle");
        Element author = doc.createElement("docAuthor");
        Element textTitle = doc.createElement("text");
        textTitle.appendChild(doc.createTextNode(metadata.getTitle()));
        title.appendChild(textTitle);

        Element textAuthor = doc.createElement("text");
        textAuthor.appendChild(doc.createTextNode(metadata.getCreator()));
        author.appendChild(textAuthor);

        rootElement.appendChild(title);
        rootElement.appendChild(author);

    }

    private void appendNavPoints(Document doc, Element rootElement, Vector<String> toc) {
        Element navMap = doc.createElement("navMap");
        int counter = 1;
        for (String link : toc) {

            Element navPoint = doc.createElement("navPoint");
            navPoint.setAttribute("id", "navpoint-" + counter);
            navPoint.setAttribute("playOrder", String.valueOf(counter));
            Element navLabel = doc.createElement("navLabel");
            Element text = doc.createElement("text");
            if (counter == 1) {
                text.appendChild(doc.createTextNode("Seznam obsahu"));
            } else {
                text.appendChild(doc.createTextNode("Kapitola " + (counter - 1)));
            }

            navLabel.appendChild(text);
            navPoint.appendChild(navLabel);

            Element content = doc.createElement("content");
            content.setAttribute("src", link);
            navPoint.appendChild(content);
            navMap.appendChild(navPoint);
            counter++;
        }

        rootElement.appendChild(navMap);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertor;

import java.io.File;
import java.util.Vector;

/**
 *
 * @author Hubacek
 */
public class Metadata {

    Vector<String> required = new Vector<String>();
    Vector<String> optional = new Vector<String>();

    public Metadata() {

    }

    public String getTitle() {
        return required.get(0);
    }

    public String getCreator() {
        return required.get(1);
    }

    public String getLanguage() {
        return required.get(2);
    }

    public String getPublisher() {
        return optional.get(0);
    }

    public String getContributor() {
        return optional.get(1);
    }

    public String getIdentifier() {
        return optional.get(2);
    }

    public String getDate() {
        return optional.get(3);
    }

    public String getDescription() {
        return optional.get(4);
    }

    public String getImagePath() {
        return (optional.size()>0)?optional.get(5):null;
    }

    public Vector<String> getRequired() {
        return this.required;
    }

    public Vector<String> getOptional() {
        return this.optional;
    }

    public void setRequiredData(Vector<String> required) {
        this.required = required;
    }

    public void setOptionalData(Vector<String> optional) {
        this.optional = optional;
    }

    public void clear() {
        required = new Vector<String>();
        optional = new Vector<String>();
    }
    public void setImagePath(String imagePath) {
        optional.set(5, imagePath);
    }

    public boolean isImageSet() {
        boolean out = false;
        if(optional.size()==6){
            String path = optional.get(5);
            if(path!=null){
                File f = new File(path);
                out = f.exists();
            }  
        }
        return out;
    }

    public boolean isRequiredSet() {
        return (this.required.size()!=0)?true:false;
    }


}

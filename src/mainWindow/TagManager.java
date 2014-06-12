/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainWindow;

import java.util.LinkedList;

/**
 *
 * @author Hubacek
 */
class TagManager {
    
    static String BOLD = "bold";

    LinkedList<Tag> list = new LinkedList<>();
    
    public TagManager(){
    
    }
    
    public int addTag(int location, String singleTag){
        int relativeDistance=location;
        
        if(list.size()==0){
            list.add(new Tag(relativeDistance,singleTag));
        }else{
            int offset = 0;
            int sizeOfTags=0;
            for(int poz = 0;poz<list.size();poz++){
                Tag acctualTag = list.get(poz);
                offset+=acctualTag.distance;
                sizeOfTags+=acctualTag.name.length();
                
                if(offset>location){
                    list.add(poz,new Tag(location-(offset-acctualTag.distance), singleTag));
                    list.get(poz+1).distance = offset-location;
                    relativeDistance=location+(sizeOfTags-acctualTag.name.length());
                    break;
                }
                if(offset==location){
                    if(acctualTag.name.startsWith("[/")){
                        for(int position2 = poz;position2<list.size();position2++){
                            if(list.get(position2).distance!=0)break;
                            else{
                                sizeOfTags+=list.get(position2).name.length();
                            }
                        }
                        list.add(new Tag(location-offset, singleTag));
                        relativeDistance=location+sizeOfTags;

                    
                    }else{
                        list.add(new Tag(location-offset, singleTag));
                        relativeDistance=location+sizeOfTags;
                    }

                    break;
                }
            }

            if(offset<location){
                list.add(new Tag(location-offset, singleTag));
                relativeDistance=location+sizeOfTags;
            }
        
        }
        return relativeDistance;

    }

    
    @Override
    public String toString() {
        boolean start = true;
        String output = "";
        for(Tag tag :list){
            if(start){
                output+=("["+tag.distance+","+tag.name+"]");
                start =false;
            } 
            else output+=(",["+tag.distance+","+tag.name+"]");
        }
        
        return output;
    }    
}

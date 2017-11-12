
package datafromserver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phant
 */
public class Message implements  Serializable{
    private List < String >  list = new ArrayList<>();

    public Message(List<String> list) {
        this.list = list ;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
     
    
    
}

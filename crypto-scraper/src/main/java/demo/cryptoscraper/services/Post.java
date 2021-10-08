package demo.cryptoscraper.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Post {


    private ArrayList status = new ArrayList();

    private List<DataPojo> data;

    public List<DataPojo> getData() {
        return data;
    }

    public void setData(List<DataPojo> data) {
        this.data = data;
    }




    public ArrayList getStatus() {
        return status;
    }

    public void setStatus(ArrayList status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Post{" +
                "data=" + data +
                '}';
    }


}

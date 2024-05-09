package buttonsBeans;


import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@Data
@ManagedBean(name = "yButton", eager = true)
public class yButtonBean implements Serializable {
    private String data;
    private String clickData;
}

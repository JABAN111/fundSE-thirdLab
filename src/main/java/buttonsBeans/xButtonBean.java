package buttonsBeans;


import lombok.Data;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "xButton", eager = true)
@SessionScoped
@Data
public class xButtonBean implements Serializable {
    private Double data;
    private Float clickData;
}
package buttonsBeans.rButtons;

import lombok.Data;

import java.io.Serializable;

@Data
public class RValue implements Serializable {
    private Float label;
    private boolean value;

    public RValue(Float label,boolean value) {
        this.label = label;
        this.value = value;
    }
}

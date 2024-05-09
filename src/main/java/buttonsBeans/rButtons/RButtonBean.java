package buttonsBeans.rButtons;

import lombok.Getter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@ManagedBean(name="RButton", eager = true)
@SessionScoped
public class RButtonBean implements Serializable {

    private final List<RValue> availableValues;

    public RButtonBean() {
        availableValues = new ArrayList<>();
        availableValues.add(new RValue(1f,false));
        availableValues.add(new RValue(1.5f, false));
        availableValues.add(new RValue(2f,false));
        availableValues.add(new RValue(2.5f ,false));
        availableValues.add(new RValue(3f,false));
    }
    public int getCountCheckedButtons(){
        int cnt = 0;
        for(RValue value : availableValues){
            if(value.isValue())
                cnt++;
        }
        return cnt;
    }

    /**
     * Вспомагательная функция для того, чтобы пользователь мог выбрать только один параметр R
     * @param num - номер кнопки в массиве availableValues
     */
public void pickButtonProcessing(int num){
        if(num >= 0 && num < 5){
            for (int i = 0; i < availableValues.size(); i++) {
                //скипаем наш элемент
                if(i == num) {
                    continue;
                }
                availableValues.get(i).setValue(false);
            }
        }
    }

    public Float getPickedR(){
        if(getCountCheckedButtons() != 1 || getCountCheckedButtons() == 0){
            return null;
        }
        for (RValue value : availableValues){
            if(value.isValue()){
                return value.getLabel();
            }
        }
        return null;
    }
}

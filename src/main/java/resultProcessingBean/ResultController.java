package resultProcessingBean;

import coordinateProcessing.AreaProcessing;
import dataBaseHandler.ResultEntity;
import dataBaseHandler.service.resultServiceImpl;
import lombok.Data;
import org.primefaces.PrimeFaces;
import utils.DotTransformer;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


@ManagedBean(name = "Controller", eager = true)
@ApplicationScoped
@Data
public class ResultController implements Serializable {
    private volatile List<ResultEntity> results;
    private final AreaProcessing areaProcessing = new AreaProcessing();
    private final resultServiceImpl resultService = new resultServiceImpl();
    private boolean hitStatus;

    public ResultController(){
        if(results == null)
            results = new ArrayList<>();
        getAllResults();
    }

    private void saveResultLocal(ResultEntity entity){
        if(results == null)
            results = new ArrayList<>();
        results.add(entity);
    }

    private void getAllResults(){
        results = resultService.getAllResults();
    }

    public void addResult(Double x, String y_value, Float R){
        if(y_value == null || x == null || R==null)
            return;

        x = Math.floor(x * 1000) / 1000;
        Double y = DotTransformer.dotTransform(y_value);

        Date date = new Date();
        hitStatus = areaProcessing.areaCheck(x,y,R);
        ResultEntity result = new ResultEntity(x,y,R,date, hitStatus);
        saveResultLocal(result);
        resultService.addResult(result);
        String script = String.format(Locale.US,"window.printDotOnGraph(%f,%f,%b);",x,y,hitStatus);
        PrimeFaces.current().executeScript(script);
    }
    public void cleanResults(){
        if(results != null)
            results.clear();
        resultService.cleanResults();
    }
}

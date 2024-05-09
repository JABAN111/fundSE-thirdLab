package coordinateProcessing;

public class AreaProcessing implements CartesianAreas {

    @Override
    public boolean firstRotation(Double x, Double y, Float R) {
        if(x >= 0 && y >= 0){
            return x <= R / 2 && y <= R;
        }
        return false;
    }

    @Override
    public boolean secondRotation(Double x, Double y, Float R) {
        if(x<=0 && y>=0){
            double line = x + R/2;
            return line>=y && x>=-R/2 && y<=R/2;
        }
        return false;
    }

    @Override
    public boolean thirdRotation(Double x, Double y, Float R) {
        if(x <= 0 && y <= 0){
            double circle = x*x+y*y;
            return circle <= R*R && x>=-R && y>=-R;
        }
        return false;
    }

    @Override
    public boolean fourthRotation(Double x, Double y, Float R) {
        return false;
    }

    @Override
    public boolean areaCheck(Double x, Double y, Float R) {
        return firstRotation(x,y,R) || secondRotation(x,y,R) || thirdRotation(x,y,R) || fourthRotation(x,y,R);
    }
}

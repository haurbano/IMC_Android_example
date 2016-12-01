package salt.movil.imcproject.models;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by Hamilton Urbano on 01/12/2016.
 */

public class ImcItem extends SugarRecord {
    int img;
    String resultado;
    Float pase, estatura;
    Date date;

    public ImcItem() {
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Float getPase() {
        return pase;
    }

    public void setPase(Float pase) {
        this.pase = pase;
    }

    public Float getEstatura() {
        return estatura;
    }

    public void setEstatura(Float estatura) {
        this.estatura = estatura;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

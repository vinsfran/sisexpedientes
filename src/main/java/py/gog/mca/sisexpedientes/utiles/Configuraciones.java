/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gog.mca.sisexpedientes.utiles;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vinsfran
 */
public class Configuraciones implements Serializable {

    private Integer codConfiguracion;
    private String detalleDeConfiguracion;
    private String par01;
    private String par02;
    private String par03;
    private String par04;
    private String par05;
    private String par06;
    private String par07;
    private String par08;
    private String par09;
    private String par10;
    private String par11;
    private String par12;
    private String par13;
    private String par14;
    private String par15;
    private String par16;
    private String par17;
    private String par18;
    private String par19;
    private String par20;
    private String par21;
    private String par22;
    private String par23;
    private String par24;
    private String par25;
    private String par26;
    private String par27;
    private String par28;
    private String par29;
    private String par30;
    private String par31;
    private String par32;
    private String par33;
    private String par34;
    private String par35;
    private String par36;
    private String par37;
    private String par38;
    private String par39;
    private String par40;

    public Configuraciones() {
    }

    public Configuraciones(Integer codConfiguracion) {
        this.codConfiguracion = codConfiguracion;
    }

    public Integer getCodConfiguracion() {
        return codConfiguracion;
    }

    public void setCodConfiguracion(Integer codConfiguracion) {
        this.codConfiguracion = codConfiguracion;
    }

    public String getDetalleDeConfiguracion() {
        return detalleDeConfiguracion;
    }

    public void setDetalleDeConfiguracion(String detalleDeConfiguracion) {
        this.detalleDeConfiguracion = detalleDeConfiguracion;
    }

    public String getPar01() {
        return par01;
    }

    public void setPar01(String par01) {
        this.par01 = par01;
    }

    public String getPar02() {
        return par02;
    }

    public void setPar02(String par02) {
        this.par02 = par02;
    }

    public String getPar03() {
        return par03;
    }

    public void setPar03(String par03) {
        this.par03 = par03;
    }

    public String getPar04() {
        return par04;
    }

    public void setPar04(String par04) {
        this.par04 = par04;
    }

    public String getPar05() {
        return par05;
    }

    public void setPar05(String par05) {
        this.par05 = par05;
    }

    public String getPar06() {
        return par06;
    }

    public void setPar06(String par06) {
        this.par06 = par06;
    }

    public String getPar07() {
        return par07;
    }

    public void setPar07(String par07) {
        this.par07 = par07;
    }

    public String getPar08() {
        return par08;
    }

    public void setPar08(String par08) {
        this.par08 = par08;
    }

    public String getPar09() {
        return par09;
    }

    public void setPar09(String par09) {
        this.par09 = par09;
    }

    public String getPar10() {
        return par10;
    }

    public void setPar10(String par10) {
        this.par10 = par10;
    }

    public String getPar11() {
        return par11;
    }

    public void setPar11(String par11) {
        this.par11 = par11;
    }

    public String getPar12() {
        return par12;
    }

    public void setPar12(String par12) {
        this.par12 = par12;
    }

    public String getPar13() {
        return par13;
    }

    public void setPar13(String par13) {
        this.par13 = par13;
    }

    public String getPar14() {
        return par14;
    }

    public void setPar14(String par14) {
        this.par14 = par14;
    }

    public String getPar15() {
        return par15;
    }

    public void setPar15(String par15) {
        this.par15 = par15;
    }

    public String getPar16() {
        return par16;
    }

    public void setPar16(String par16) {
        this.par16 = par16;
    }

    public String getPar17() {
        return par17;
    }

    public void setPar17(String par17) {
        this.par17 = par17;
    }

    public String getPar18() {
        return par18;
    }

    public void setPar18(String par18) {
        this.par18 = par18;
    }

    public String getPar19() {
        return par19;
    }

    public void setPar19(String par19) {
        this.par19 = par19;
    }

    public String getPar20() {
        return par20;
    }

    public void setPar20(String par20) {
        this.par20 = par20;
    }

    public String getPar21() {
        return par21;
    }

    public void setPar21(String par21) {
        this.par21 = par21;
    }

    public String getPar22() {
        return par22;
    }

    public void setPar22(String par22) {
        this.par22 = par22;
    }

    public String getPar23() {
        return par23;
    }

    public void setPar23(String par23) {
        this.par23 = par23;
    }

    public String getPar24() {
        return par24;
    }

    public void setPar24(String par24) {
        this.par24 = par24;
    }

    public String getPar25() {
        return par25;
    }

    public void setPar25(String par25) {
        this.par25 = par25;
    }

    public String getPar26() {
        return par26;
    }

    public void setPar26(String par26) {
        this.par26 = par26;
    }

    public String getPar27() {
        return par27;
    }

    public void setPar27(String par27) {
        this.par27 = par27;
    }

    public String getPar28() {
        return par28;
    }

    public void setPar28(String par28) {
        this.par28 = par28;
    }

    public String getPar29() {
        return par29;
    }

    public void setPar29(String par29) {
        this.par29 = par29;
    }

    public String getPar30() {
        return par30;
    }

    public void setPar30(String par30) {
        this.par30 = par30;
    }

    public String getPar31() {
        return par31;
    }

    public void setPar31(String par31) {
        this.par31 = par31;
    }

    public String getPar32() {
        return par32;
    }

    public void setPar32(String par32) {
        this.par32 = par32;
    }

    public String getPar33() {
        return par33;
    }

    public void setPar33(String par33) {
        this.par33 = par33;
    }

    public String getPar34() {
        return par34;
    }

    public void setPar34(String par34) {
        this.par34 = par34;
    }

    public String getPar35() {
        return par35;
    }

    public void setPar35(String par35) {
        this.par35 = par35;
    }

    public String getPar36() {
        return par36;
    }

    public void setPar36(String par36) {
        this.par36 = par36;
    }

    public String getPar37() {
        return par37;
    }

    public void setPar37(String par37) {
        this.par37 = par37;
    }

    public String getPar38() {
        return par38;
    }

    public void setPar38(String par38) {
        this.par38 = par38;
    }

    public String getPar39() {
        return par39;
    }

    public void setPar39(String par39) {
        this.par39 = par39;
    }

    public String getPar40() {
        return par40;
    }

    public void setPar40(String par40) {
        this.par40 = par40;
    }
    
}

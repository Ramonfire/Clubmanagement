package com.example.Clubmanagement.entities.compte.Clubsmembers;


//@Entity
//@Table(name="Club_students")
public class Members {
   private long idc;
   private  long idE;


    public Members() {
    }

    public Members(long idc, long idE) {
        this.idc = idc;
        this.idE = idE;
    }


    public long getIdc() {
        return idc;
    }

    public void setIdc(long idc) {
        this.idc = idc;
    }

    public long getIdE() {
        return idE;
    }

    public void setIdE(long idE) {
        this.idE = idE;
    }


    @Override
    public String toString() {
        return "Members{" +
                "idc=" + idc +
                ", idE=" + idE +
                '}';
    }

}

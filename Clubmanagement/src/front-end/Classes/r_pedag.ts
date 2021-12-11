class Rpedag extends compte{
    public departement:String;

    constructor(idE: number, civilite: number, fullname: String, email: String, password: String, tel: number, departement: String) {
        super(idE, civilite, fullname, email, password, tel);
        this.departement = departement;
    }
}
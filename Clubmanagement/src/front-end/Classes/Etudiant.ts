import {compte} from "./compte";

export class etudiant extends compte{

    public anneetude:String;
    public progamme:String;

    constructor(idE: number, civilite: number, fullname: String, email: String, password: String, tel: number, anneetude: String, progamme: String) {
        super(idE, civilite, fullname, email, password, tel);
        this.anneetude = anneetude;
        this.progamme = progamme;
    }

}
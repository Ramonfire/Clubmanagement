import {compte} from "./compte";

export class etudiant extends compte{

    private _anetud:String;
    private _progamme:String;


    get anetud(): String {
        return this._anetud;
    }

    set anetud(value: String) {
        this._anetud = value;
    }

    get progamme(): String {
        return this._progamme;
    }

    set progamme(value: String) {
        this._progamme = value;
    }

    constructor(idE: number, civilite: number, fullname: String, email: String, password: String, tel: number, anneetude: String, progamme: String) {
        super(idE, civilite, fullname, email, password, tel);
        this._anetud = anneetude;
        this._progamme = progamme;
    }

}
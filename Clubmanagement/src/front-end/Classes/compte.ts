export class compte {

    private _idE:number;
    private _civilite:number;
    private _fullname:String;
     private _email: String;
     private _pass :String;
     private _tel:number;
     private _roles: Array<String>;


     get idE(): number {
         return this._idE;
     }

     set idE(value: number) {
         this._idE = value;
     }


    get civilite(): number {
        return this._civilite;
    }

    set civilite(value: number) {
        this._civilite = value;
    }

    get fullname(): String {
        return this._fullname;
    }

    set fullname(value: String) {
        this._fullname = value;
    }

    get email(): String {
        return this._email;
    }

    set email(value: String) {
        this._email = value;
    }


    get pass(): String {
        return this._pass;
    }

    set pass(value: String) {
        this._pass = value;
    }

    get tel(): number {
        return this._tel;
    }

    set tel(value: number) {
        this._tel = value;
    }

    get roles(): Array<String> {
        return this._roles;
    }

    set roles(value: Array<String>) {
        this._roles = value;
    }

    constructor(idE: number, civilite: number, fullname: String, email: String, password: String, tel: number) {
         this._idE = idE;
         this._civilite = civilite;
         this._fullname = fullname;
         this._email = email;
         this._pass = password;
         this._tel = tel;
     }
 }
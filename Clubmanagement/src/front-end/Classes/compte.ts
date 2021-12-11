 class compte {

    private _idE:number;
    public civilite:number;
    public  fullname:String;
     public email: String;
     public password :String;
     public tel:number;


     get idE(): number {
         return this._idE;
     }

     set idE(value: number) {
         this._idE = value;
     }

     constructor(idE: number, civilite: number, fullname: String, email: String, password: String, tel: number) {
         this._idE = idE;
         this.civilite = civilite;
         this.fullname = fullname;
         this.email = email;
         this.password = password;
         this.tel = tel;
     }
 }
export class Session {
   private _acces_token:String;
   private _refresh_token:String;


   get acces_token(): String {
      return this._acces_token;
   }

   set acces_token(value: String) {
      this._acces_token = value;
   }

   get refresh_token(): String {
      return this._refresh_token;
   }

   set refresh_token(value: String) {
      this._refresh_token = value;
   }

   constructor() {
   }
}
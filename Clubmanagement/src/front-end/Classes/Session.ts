class Session {
   private _access_token:String;
   private _refresh_token:String;


   get access_token(): String {
      return this._access_token;
   }

   set access_token(value: String) {
      this._access_token = value;
   }

   get refresh_token(): String {
      return this._refresh_token;
   }

   set refresh_token(value: String) {
      this._refresh_token = value;
   }
}
export class Members {

   private _idmember:number;
    private _clubid:number;
    private _studentid:number;
    private _role:string;


    get idmember(): number {
        return this._idmember;
    }

    set idmember(value: number) {
        this._idmember = value;
    }

    get clubid(): number {
        return this._clubid;
    }

    set clubid(value: number) {
        this._clubid = value;
    }

    get studentid(): number {
        return this._studentid;
    }

    set studentid(value: number) {
        this._studentid = value;
    }

    get role(): string {
        return this._role;
    }

    set role(value: string) {
        this._role = value;
    }

    constructor( clubid: number, studentid: number, role: string) {
        this.idmember=null;
        this._clubid = clubid;
        this._studentid = studentid;
        this._role = role;
    }
    public ToString():string{
        return "club id : "+this.clubid +"role :"+ this.role;
    }
}
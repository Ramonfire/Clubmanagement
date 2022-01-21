export class Facture {
    private _idfacture:number;
    private _frais:number;
    private _eventname:string;


    get idfacture(): number {
        return this._idfacture;
    }

    set idfacture(value: number) {
        this._idfacture = value;
    }

    get frais(): number {
        return this._frais;
    }

    set frais(value: number) {
        this._frais = value;
    }

    get eventname(): string {
        return this._eventname;
    }

    set eventname(value: string) {
        this._eventname = value;
    }
}
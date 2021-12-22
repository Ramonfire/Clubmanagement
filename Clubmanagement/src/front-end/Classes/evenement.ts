

export class Evenement {
    private _idevent:number;
    private _description:String;
    private _nomevent:String;
    private _type :number;
    private _etat : number;
    private _terminer : boolean;


    get idevent(): number {
        return this._idevent;
    }

    set idevent(value: number) {
        this._idevent = value;
    }

    get description(): String {
        return this._description;
    }

    set description(value: String) {
        this._description = value;
    }

    get nomevent(): String {
        return this._nomevent;
    }

    set nomevent(value: String) {
        this._nomevent = value;
    }

    get type(): number {
        return this._type;
    }

    set type(value: number) {
        this._type = value;
    }

    get etat(): number {
        return this._etat;
    }

    set etat(value: number) {
        this._etat = value;
    }

    get terminer(): boolean {
        return this._terminer;
    }

    set terminer(value: boolean) {
        this._terminer = value;
    }
}
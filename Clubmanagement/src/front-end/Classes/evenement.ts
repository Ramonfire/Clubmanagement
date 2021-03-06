import {Facture} from "./facture";


export class Evenement {
    private _idevent:number;
    private _description:string;
    private _nomevent:string;
    private _type :number;
    private _state : number;
    private _terminer : boolean;
    private _fact:Facture=new Facture();


    get idevent(): number {
        return this._idevent;
    }

    set idevent(value: number) {
        this._idevent = value;
    }

    get description(): string {
        return this._description;
    }

    set description(value: string) {
        this._description = value;
    }

    get nomevent(): string {
        return this._nomevent;
    }

    set nomevent(value: string) {
        this._nomevent = value;
    }

    get type(): number {
        return this._type;
    }

    set type(value: number) {
        this._type = value;
    }

    get state(): number {
        return this._state;
    }

    set state(value: number) {
        this._state = value;
    }

    get terminer(): boolean {
        return this._terminer;
    }

    set terminer(value: boolean) {
        this._terminer = value;
    }

    get fact(): Facture {
        return this._fact;
    }

    set fact(value: Facture) {
        this._fact = value;
    }
}
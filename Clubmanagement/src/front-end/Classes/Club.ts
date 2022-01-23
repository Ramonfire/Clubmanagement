import {etudiant} from "./Etudiant";
import {Evenement} from "./evenement";
import {Rpedag} from "./r_pedag";

export class Club {
    //image a ajouter
    private _idc:number;
    private _nomclub:string;
    private _etat: number;
    private _description:string;
    private _students:etudiant[];
    private _budget:number;
    //private budget
    private _ev:Evenement[];
    private _ped:Rpedag;


    get nomclub(): string {
        return this._nomclub;
    }

    set nomclub(value: string) {
        this._nomclub = value;
    }

    get description(): string {
        return this._description;
    }

    set description(value: string) {
        this._description = value;
    }

    get idc(): number {
        return this._idc;
    }

    set idc(value: number) {
        this._idc = value;
    }




    get etat(): number {
        return this._etat;
    }

    set etat(value: number) {
        this._etat = value;
    }



    get students(): etudiant[] {
        return this._students;
    }

    set students(value: etudiant[]) {
        this._students = value;
    }

    get Ev(): Evenement[] {
        return this._ev;
    }

    set Ev(value: Evenement[]) {
        this._ev = value;
    }

    get Ped(): Rpedag {
        return this._ped;
    }

    set Ped(value: Rpedag) {
        this._ped = value;
    }

    get budget(): number {
        return this._budget;
    }

    set budget(value: number) {
        this._budget = value;
    }
}
import {etudiant} from "./Etudiant";
import {Evenement} from "./evenement";
import {Rpedag} from "./r_pedag";

export class Club {
    //image a ajouter
    private _id:number;
    private _nomclub:String;
    private _etat: number;
    private _description:String;
    private _students:etudiant[];
    //private budget
    private _ev:Evenement[];
    private _ped:Rpedag;


    get id(): number {
        return this._id;
    }

    set id(value: number) {
        this._id = value;
    }

    get nomclub(): String {
        return this._nomclub;
    }

    set nomclub(value: String) {
        this._nomclub = value;
    }

    get etat(): number {
        return this._etat;
    }

    set etat(value: number) {
        this._etat = value;
    }

    get description(): String {
        return this._description;
    }

    set description(value: String) {
        this._description = value;
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
}
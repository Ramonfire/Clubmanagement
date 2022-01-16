export class Demande {
    private _idDem : number;
    private _idEtudiant: number;
    private _typedeDem:string;
    private _nomClubD:string;
    private _descrpt:string;
    private _etatD:number;


    get idDem(): number {
        return this._idDem;
    }

    set idDem(value: number) {
        this._idDem = value;
    }

    get idEtudiant(): number {
        return this._idEtudiant;
    }

    set idEtudiant(value: number) {
        this._idEtudiant = value;
    }

    get typedeDem(): string {
        return this._typedeDem;
    }

    set typedeDem(value: string) {
        this._typedeDem = value;
    }

    get nomClubD(): string {
        return this._nomClubD;
    }

    set nomClubD(value: string) {
        this._nomClubD = value;
    }

    get descrpt(): string {
        return this._descrpt;
    }

    set descrpt(value: string) {
        this._descrpt = value;
    }

    get etatD(): number {
        return this._etatD;
    }

    set etatD(value: number) {
        this._etatD = value;
    }


    constructor(  typedeDem: string, nomClubD: string, descrpt: string, etatD: number) {
        this._idDem = null;
        this._idEtudiant = 0;
        this._typedeDem = typedeDem;
        this._nomClubD = nomClubD;
        this._descrpt = descrpt;
        this._etatD = etatD;
    }
}
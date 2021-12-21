import {Club} from "./Club";

export class Evenement {
    public id:number;
    public description:String;
    public name:String;
    public type :number;
    public etat : number;
    private terminer : boolean;
    public Club:Club;
}
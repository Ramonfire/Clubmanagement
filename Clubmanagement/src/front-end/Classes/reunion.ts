export class Reunion {
 private _idreunion:number;
 private _datedebut:Date;
 private _duree:number;
 private _object:string;
 private _lieu:string;


 get idreunion(): number {
  return this._idreunion;
 }

 set idreunion(value: number) {
  this._idreunion = value;
 }

 get datedebut(): Date {
  return this._datedebut;
 }

 set datedebut(value: Date) {
  this._datedebut = value;
 }

 get duree(): number {
  return this._duree;
 }

 set duree(value: number) {
  this._duree = value;
 }

 get object(): string {
  return this._object;
 }

 set object(value: string) {
  this._object = value;
 }

 get lieu(): string {
  return this._lieu;
 }

 set lieu(value: string) {
  this._lieu = value;
 }
}
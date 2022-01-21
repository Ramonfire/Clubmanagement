import {Byte} from "@angular/compiler/src/util";

export class ImageModel {
    private _id:number;
    private _name:string;
    private _type:string;
    private _picByte:Array<any>;

    get id(): number {
        return this._id;
    }

    set id(value: number) {
        this._id = value;
    }

    get name(): string {
        return this._name;
    }

    set name(value: string) {
        this._name = value;
    }

    get type(): string {
        return this._type;
    }

    set type(value: string) {
        this._type = value;
    }


    get picByte(): Array<any> {
        return this._picByte;
    }

    set picByte(value: Array<any>) {
        this._picByte = value;
    }
}
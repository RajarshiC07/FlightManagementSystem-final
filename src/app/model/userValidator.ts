import { AbstractControl } from "@angular/forms";

export function forbiddenNameValidator(control:AbstractControl):{[key:string]:any}|null
{
    const forbidden = control.value.toString().length<3;
    return forbidden ? {'forbiddenLength':{value:control.value}}:null;
}
export function forbiddenMailValidator(control:AbstractControl):{[key:string]:any}|null
{
    const forbidden = !control.value.toString().match("^[a-zA-Z0-9+]+@[a-zA-Z0-9.-]+$");
    return forbidden ? {'forbiddenMail':{value:control.value}}:null;
}
export function forbiddenPhoneValidator(control:AbstractControl):{[key:string]:any}|null
{
    const forbidden = !control.value.toString().match("^[1-9]{1}[0-9]{9}$");
    return forbidden ? {'forbiddenPhone':{value:control.value}}:null;
}
export function forbiddenTypeValidator(control:AbstractControl):{[key:string]:any}|null
{
    const forbidden = !control.value.toString().match("Admin") && !control.value.toString().match("Customer");

    return forbidden ? {'forbiddenType':{value:control.value}}:null;
}
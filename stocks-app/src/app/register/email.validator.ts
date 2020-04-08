import { ValidatorFn, FormGroup } from '@angular/forms';



export class EmailValidator {

    static mustBeEqual: ValidatorFn = (fg: FormGroup) => {
        const email = fg.get('email').value;
        const confirm = fg.get('confirmEmail').value;
        
        return email === confirm && email != '' && confirm != '' ? null
         : { email: true };
      };

}
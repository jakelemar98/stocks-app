import { ValidatorFn, FormGroup } from '@angular/forms';

  

export class PasswordValidator {

    static mustBeEqual: ValidatorFn = (fg: FormGroup) => {
        const password = fg.get('password').value;
        const confirm = fg.get('confirmPass').value;
        
        return password === confirm && password != '' && confirm != '' ? null
         : { password: true };
      };

}
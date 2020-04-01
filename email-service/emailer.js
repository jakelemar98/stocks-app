const nodemailer = require('nodemailer');

let transport = nodemailer.createTransport({
    host: "smtp.mailtrap.io",
    port: 2525,
    auth: {
      user: "b13d1aada039de",
      pass: "f64b06a26aa93b"
    }
});
module.exports = {
  sendEmail: function (to, from, subject, body) {
    const message = {
      from: from,
      to: to,
      subject: subject,
      html: body
    };
    transport.sendMail(message, function(err, info) {
        if (err) {
          return(err)
        } else {
          return(info);
        }
    });
}

}

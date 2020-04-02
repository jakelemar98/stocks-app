const nodemailer = require('nodemailer');

let transport = nodemailer.createTransport({
    host: "smtp.zoho.com",
    port: 465,
    secure: true,
    auth: {
      user: "mail@stocks4fun.com",
      pass: "qRtiyKsT6JVX"
    }
});
module.exports = {
  sendEmail: function (to, subject, body) {
    const message = {
      from: "mail@stocks4fun.com",
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

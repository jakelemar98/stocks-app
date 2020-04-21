
async function addVerify(verifyInfo) {
    const { Verify } = require('./mongo');    
    const verify = await Verify.addVerified(verifyInfo);
    return verify;
}

module.exports = { addVerify }

async function addVerify(verifyInfo) {
    const { Verify } = require('./mongo');    
    const verify = await Verify.addVerified(verifyInfo);
    return verify;
}

async function checkVerified(id) {
    const { Verify } = require('./mongo');
    const record = await Verify.checkVerified(id);
    return record;
}

async function deleteVerified(id) {
    const { Verify } = require('./mongo');
    const record = await Verify.deleteVerified(id);
    return record;
}

module.exports = { addVerify, checkVerified, deleteVerified }
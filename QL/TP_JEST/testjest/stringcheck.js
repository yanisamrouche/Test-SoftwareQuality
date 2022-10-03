function isEmpty(str){
    let newStr = str.trim();
    return newStr.length == 0;
}

function isInt(str){
    if(!isEmpty(str)){
        let i = parseInt(str);
        return Number.isInteger(i);
    }
    return false;
}

function isSmallPositiveInt(str){
    if(!isEmpty(str) && isInt(str)){
        let i = parseInt(str);
        if(i >= 0 && i < 100){
            return true;
        }
    }
    return false;
}
module.exports = {isEmpty, isInt, isSmallPositiveInt};
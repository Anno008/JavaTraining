var findIndex = (array, comperator) => {
    for (var i = 0; i < array.length; i++) {
        if (comperator(array[i])) {
            return i;
        }
    }
    return -1;
}

var fromPairs = (arrays) => {
    retVal = {};
    for(var i = 0; i <arrays.length; i++) {
        retVal[arrays[i][0]] = arrays[i][1];
    }
    return retVal;
}
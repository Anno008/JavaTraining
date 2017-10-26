var findIndex = (array, comperator) => {
    for (var i = 0; i < array.length; i++) {
        if (comperator(array[i])) {
            return i;
        }
    }
    return -1;
}
var isEmpty = function (obj) {
    return obj === undefined || obj === null || obj === ''
}

var isNotEmpty = function (obj) {
    return !isEmpty(obj)
}

export {
    isEmpty,
    isNotEmpty
}

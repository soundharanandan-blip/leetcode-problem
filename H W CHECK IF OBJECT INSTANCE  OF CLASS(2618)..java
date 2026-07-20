/**
 * @param {*} obj
 * @param {*} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    // If obj is null/undefined or classFunction is invalid/lacks a prototype
    if (obj === null || obj === undefined || typeof classFunction !== 'function') {
        return false;
    }

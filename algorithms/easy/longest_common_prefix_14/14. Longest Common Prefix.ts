/**
 * @param {string[]} arr
 * @return {string}
 */
// const longestCommonPrefix = function (arr: string[]): string {
//     let prefix = "";
//     let i = 0;
//     if (arr[0] === undefined) return ""
//     while (i < arr[0].length) {
//         let ch = arr[0][i]
//         for (let j = 1; j < arr.length; j++) {
//             if (arr[j][i] !== ch) return prefix
//         }
//         i++;
//         prefix += ch;
//     }
//     return prefix
// }

const longestCommonPrefix = function (arr:string[]):string {
    if (arr.length === 0) return "";
    let prefix = arr[0];
    for (let i = 1; i < arr.length; i++) {
        while (arr[i].indexOf(prefix) !== 0) {
            prefix = prefix.slice(0, prefix.length - 1)
        }
    }
    return prefix
};

console.log(longestCommonPrefix(["aaa","aa","aaa"]))
const stringcheck = require('./stringcheck')

describe('isEmpty', ()=>{
test.each([ [' ', true], ['', true], ['yanis', false], [' ssssss', false]])(
    'str %s = %d', (n, expected) => {
        expect(stringcheck.isEmpty(n)).toBe(expected);
}
);
})

describe('isInt', ()=>{
    test.each([['123', true], ['haha', false], [' haha', false], ['80', true], [' -20', true], ['', false]])(
        'str %s=%d', (n,expected) => {
            expect(stringcheck.isInt(n)).toBe(expected)
        }
    )
})

describe('isSmallPositiveInt', ()=>{
    test.each([['80', true], ['123', false], ['haha', false], [' ', false], ['-50', false], [' -50', false], [' 50', true], ['100', false], ['0', true], ['1', true]])(
        'str %s=%d', (n,expected) => {
            expect(stringcheck.isSmallPositiveInt(n)).toBe(expected)
        }
    )
})
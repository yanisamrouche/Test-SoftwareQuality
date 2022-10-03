const stringcheck = require('./stringcheck')

describe('isEmpty', ()=> {

    test(`isEmpty(' ')`, ()=>{
        expect(stringcheck.isEmpty(' ')).toBe(true);
    })

    test(`isEmpty('')`, ()=>{
        expect(stringcheck.isEmpty(' ')).toBe(true);
    })
    
    test(`isEmpty('yanis')`, ()=>{
        expect(stringcheck.isEmpty('yanis')).toBe(false);
    })
    
    test(`isEmpty(' ssssss')`, ()=>{
        expect(stringcheck.isEmpty(' ssssss')).toBe(false);
    })
})

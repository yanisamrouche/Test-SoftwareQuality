const factorielle = require('./factorielle');

test.each([ [1, 1], [2, 2], [3, 6], [4, 24], [5, 120], [6, 720] ])(
    'fact %i = %i', (n, expected) => {
        expect(factorielle(n)).toBe(expected);
}
);
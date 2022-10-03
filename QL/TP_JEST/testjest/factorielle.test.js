const factorielle = require('./factorielle');

test('factorielle(2)', () => {
    expect(factorielle(2)).toBe(2);
});

test('factorielle(3)', () => {
    expect(factorielle(3)).toBe(6);
});

test('factorielle(4)', () => {
    expect(factorielle(4)).toBe(24);
});
describe('empty spec', () => {
  it('passes', () => {
    cy.visit('http://localhost:3000')  
    cy.title().should('include','SurveyJS Service')  
    cy.get('h1').contains('My Surveys')
    cy.wait(2000)
    cy.get('a[href*="/run/"]').eq(1).click()
    cy.url().should('include','/run/2')
    cy.get('input').click()
    cy.get('label input').check('Single',{force: true})
    cy.get('.sd-navigation__next-btn').click()
    cy.get('.sd-btn--action').click()
    cy.wait(2000) 
    if(cy.get('.sd-btn--action')){
    	console.log('Le formulaire n’a pas été envoyé.')
    }
    cy.get('div.sd-selectbase__column:nth-child(2) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)').click()  
    cy.get('.sd-btn--action').click()
    if(cy.get('h3').contains('Thank you for completing the survey')){
    	console.log('Le message « Thank you » est affiché.')
    }
    })
})

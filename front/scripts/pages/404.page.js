const notFound = document.createElement('div');
notFound.setAttribute('id', 'p-not-found');

export const NotFound = () => {
    notFound.innerHTML = `
        <h1>404</h1>
        <p>Page not found</p>
    `
    window.location.hash = '#404'
    return notFound
}
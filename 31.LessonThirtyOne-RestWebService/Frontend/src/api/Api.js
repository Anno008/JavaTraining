export const apiCall = async (config) => {
    return await fetch(config.url, {
        body: config.body,
        method: config.method || "GET",
        headers: new Headers(config.headers),
    }).then(response => response.json().catch(error => { throw error; }));
};

/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/app/pages/p/p-input-form-page/*.{html,ts}",
    "./src/**/*.{html,ts}",
  ],
  theme: {
    extend: {},
  },
  plugins: [
    require('@tailwindcss/forms'),
    require("tailwindcss")
  ]
}

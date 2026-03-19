export const i18n = {
  defaultLocale: 'vi',
  locales: ['en', 'fr', 'vi'],
  langDirection: {
    en: 'ltr',
    fr: 'ltr',
    vi: 'ltr'
  }
} as const

export type Locale = (typeof i18n)['locales'][number]

const Close = () => {
  return (
    <>
      <button
        type="button"
        className=" rounded-md p-2 inline-flex items-center justify-center text-gray-400 hover:text-red-500 text-[20px] "
      >
        <span className="sr-only">Close</span>
        <svg
          className="h-6 w-6"
          xmlns="http://www.w3.org/2000/svg"
          fill="none"
          viewBox="0 0 24 24"
          stroke="currentColor"
          aria-hidden="true"
        >
          <path
            strokeLinecap="round"
            strokeLinejoin="round"
            strokeWidth={2}
            d="M6 18L18 6M6 6l12 12"
          />
        </svg>
      </button>
    </>
  );
};

export default Close;
